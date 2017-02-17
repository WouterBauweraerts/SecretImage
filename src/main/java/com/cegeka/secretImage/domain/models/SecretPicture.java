package com.cegeka.secretImage.domain.models;

public class SecretPicture {

    private int pineapple;
    private Object picture;

    public SecretPicture(int pineapple, Object picture){
        this.pineapple=pineapple;
        this.picture=picture;
    }

    public int getPineapple() {
        return pineapple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecretPicture that = (SecretPicture) o;

        if (pineapple != that.pineapple) return false;
        return picture != null ? picture.equals(that.picture) : that.picture == null;
    }

    @Override
    public int hashCode() {
        int result = pineapple;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}
