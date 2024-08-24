package org.unibl.etf.ip.fitzone.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.models.dto.Mail;
import org.unibl.etf.ip.fitzone.models.entites.UserEntity;
import org.unibl.etf.ip.fitzone.models.requests.UserRequest;
import org.unibl.etf.ip.fitzone.repositories.UserRepository;

@Service
public class SignUpService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    private MailService mailService;
    @PersistenceContext
    EntityManager entityManager;

    public SignUpService(UserRepository userRepository, ModelMapper modelMapper, MailService mailService){
        this.userRepository =userRepository;
        this.modelMapper = modelMapper;
        this.mailService = mailService;
    }


    @Transactional
    public boolean signUp(final UserRequest userRequest){


        if(userRequest.getName().isEmpty() || userRequest.getSurname().isEmpty() || userRequest.getMail().isEmpty())
            return false;

        UserEntity userEntity = modelMapper.map(userRequest, UserEntity.class);

        userEntity = userRepository.saveAndFlush(userEntity);
        entityManager.refresh(userEntity);

        new Thread(() -> {
            String fullName = userRequest.getName() +  " " + userRequest.getSurname();
            String subject = "Fit Zone - Activate account";
            String activationLink = "http://localhost:8080/api/signup/activate/" + userRequest.getUsername();
            String htmlContent ="<html>"
                    + "<body>"
                    + "<p>Dear " + fullName + ",</p>"
                    + "<p>Click the button below to activate your account:</p>"
                    + "<a href=\"" + activationLink + "\" style=\"display:inline-block; padding: 10px 20px; color: white; background-color: #4CAF50; text-decoration: none;\">Activate Account</a>"
                    + "<br>"
                    + "<p>Kind regards,</p>"
                    + "<p>Fit Zone</p>"
                    + "</body>"
                    + "</html>";
            mailService.sendMail(new Mail(userRequest.getMail(), subject, fullName, userRequest.getUsername(), htmlContent));
        }).start();
        return true;
    }

    @Transactional
    public boolean activateAccount(String username){
        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity == null)
            return false;
        userEntity.setActivated(true);
        userEntity = userRepository.saveAndFlush(userEntity);
        entityManager.refresh(userEntity);

        return true;
    }
}
