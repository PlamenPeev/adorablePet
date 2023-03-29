package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.TypeOfHelp;

public final class TypeOfHelpServiceModel extends TypeOfHelp {
    public TypeOfHelpServiceModel() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "TypeOfHelpServiceModel[]";
    }

}
