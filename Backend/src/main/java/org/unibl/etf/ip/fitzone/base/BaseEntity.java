package org.unibl.etf.ip.fitzone.base;

import java.io.Serializable;

public interface BaseEntity<ID extends Serializable> {
    void setId(ID object);
    ID getId();
}

