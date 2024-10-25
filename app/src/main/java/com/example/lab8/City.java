package com.example.lab8;

public class City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    //https://www.baeldung.com/java-equals-hashcode-contracts, 2024-10-25
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof City))
            return false;
        City other = (City) o;
        boolean valueEquals = (this.city == null && other.city == null)
                || (this.city != null && this.city.equals(other.city));
        boolean storeEquals = (this.province == null && other.province == null)
                || (this.province != null && this.province.equals(other.province));
        return valueEquals && storeEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (city != null) {
            result = 31 * result + city.hashCode();
        }
        if (province != null) {
            result = 31 * result + province.hashCode();
        }
        return result;
    }
}
