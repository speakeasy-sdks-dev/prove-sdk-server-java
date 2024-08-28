/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.prove.proveapi.models.components;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prove.proveapi.utils.Utils;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;


public class DataSourceAddressResponseInternal {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("addressScore")
    private Optional<Long> addressScore;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("city")
    private Optional<Boolean> city;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("distance")
    private Optional<Double> distance;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("postalCode")
    private Optional<Boolean> postalCode;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("region")
    private Optional<Boolean> region;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("street")
    private Optional<Boolean> street;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("streetNumber")
    private Optional<Long> streetNumber;

    @JsonCreator
    public DataSourceAddressResponseInternal(
            @JsonProperty("addressScore") Optional<Long> addressScore,
            @JsonProperty("city") Optional<Boolean> city,
            @JsonProperty("distance") Optional<Double> distance,
            @JsonProperty("postalCode") Optional<Boolean> postalCode,
            @JsonProperty("region") Optional<Boolean> region,
            @JsonProperty("street") Optional<Boolean> street,
            @JsonProperty("streetNumber") Optional<Long> streetNumber) {
        Utils.checkNotNull(addressScore, "addressScore");
        Utils.checkNotNull(city, "city");
        Utils.checkNotNull(distance, "distance");
        Utils.checkNotNull(postalCode, "postalCode");
        Utils.checkNotNull(region, "region");
        Utils.checkNotNull(street, "street");
        Utils.checkNotNull(streetNumber, "streetNumber");
        this.addressScore = addressScore;
        this.city = city;
        this.distance = distance;
        this.postalCode = postalCode;
        this.region = region;
        this.street = street;
        this.streetNumber = streetNumber;
    }
    
    public DataSourceAddressResponseInternal() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public Optional<Long> addressScore() {
        return addressScore;
    }

    @JsonIgnore
    public Optional<Boolean> city() {
        return city;
    }

    @JsonIgnore
    public Optional<Double> distance() {
        return distance;
    }

    @JsonIgnore
    public Optional<Boolean> postalCode() {
        return postalCode;
    }

    @JsonIgnore
    public Optional<Boolean> region() {
        return region;
    }

    @JsonIgnore
    public Optional<Boolean> street() {
        return street;
    }

    @JsonIgnore
    public Optional<Long> streetNumber() {
        return streetNumber;
    }

    public final static Builder builder() {
        return new Builder();
    }

    public DataSourceAddressResponseInternal withAddressScore(long addressScore) {
        Utils.checkNotNull(addressScore, "addressScore");
        this.addressScore = Optional.ofNullable(addressScore);
        return this;
    }

    public DataSourceAddressResponseInternal withAddressScore(Optional<Long> addressScore) {
        Utils.checkNotNull(addressScore, "addressScore");
        this.addressScore = addressScore;
        return this;
    }

    public DataSourceAddressResponseInternal withCity(boolean city) {
        Utils.checkNotNull(city, "city");
        this.city = Optional.ofNullable(city);
        return this;
    }

    public DataSourceAddressResponseInternal withCity(Optional<Boolean> city) {
        Utils.checkNotNull(city, "city");
        this.city = city;
        return this;
    }

    public DataSourceAddressResponseInternal withDistance(double distance) {
        Utils.checkNotNull(distance, "distance");
        this.distance = Optional.ofNullable(distance);
        return this;
    }

    public DataSourceAddressResponseInternal withDistance(Optional<Double> distance) {
        Utils.checkNotNull(distance, "distance");
        this.distance = distance;
        return this;
    }

    public DataSourceAddressResponseInternal withPostalCode(boolean postalCode) {
        Utils.checkNotNull(postalCode, "postalCode");
        this.postalCode = Optional.ofNullable(postalCode);
        return this;
    }

    public DataSourceAddressResponseInternal withPostalCode(Optional<Boolean> postalCode) {
        Utils.checkNotNull(postalCode, "postalCode");
        this.postalCode = postalCode;
        return this;
    }

    public DataSourceAddressResponseInternal withRegion(boolean region) {
        Utils.checkNotNull(region, "region");
        this.region = Optional.ofNullable(region);
        return this;
    }

    public DataSourceAddressResponseInternal withRegion(Optional<Boolean> region) {
        Utils.checkNotNull(region, "region");
        this.region = region;
        return this;
    }

    public DataSourceAddressResponseInternal withStreet(boolean street) {
        Utils.checkNotNull(street, "street");
        this.street = Optional.ofNullable(street);
        return this;
    }

    public DataSourceAddressResponseInternal withStreet(Optional<Boolean> street) {
        Utils.checkNotNull(street, "street");
        this.street = street;
        return this;
    }

    public DataSourceAddressResponseInternal withStreetNumber(long streetNumber) {
        Utils.checkNotNull(streetNumber, "streetNumber");
        this.streetNumber = Optional.ofNullable(streetNumber);
        return this;
    }

    public DataSourceAddressResponseInternal withStreetNumber(Optional<Long> streetNumber) {
        Utils.checkNotNull(streetNumber, "streetNumber");
        this.streetNumber = streetNumber;
        return this;
    }
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataSourceAddressResponseInternal other = (DataSourceAddressResponseInternal) o;
        return 
            Objects.deepEquals(this.addressScore, other.addressScore) &&
            Objects.deepEquals(this.city, other.city) &&
            Objects.deepEquals(this.distance, other.distance) &&
            Objects.deepEquals(this.postalCode, other.postalCode) &&
            Objects.deepEquals(this.region, other.region) &&
            Objects.deepEquals(this.street, other.street) &&
            Objects.deepEquals(this.streetNumber, other.streetNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            addressScore,
            city,
            distance,
            postalCode,
            region,
            street,
            streetNumber);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DataSourceAddressResponseInternal.class,
                "addressScore", addressScore,
                "city", city,
                "distance", distance,
                "postalCode", postalCode,
                "region", region,
                "street", street,
                "streetNumber", streetNumber);
    }
    
    public final static class Builder {
 
        private Optional<Long> addressScore = Optional.empty();
 
        private Optional<Boolean> city = Optional.empty();
 
        private Optional<Double> distance = Optional.empty();
 
        private Optional<Boolean> postalCode = Optional.empty();
 
        private Optional<Boolean> region = Optional.empty();
 
        private Optional<Boolean> street = Optional.empty();
 
        private Optional<Long> streetNumber = Optional.empty();  
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder addressScore(long addressScore) {
            Utils.checkNotNull(addressScore, "addressScore");
            this.addressScore = Optional.ofNullable(addressScore);
            return this;
        }

        public Builder addressScore(Optional<Long> addressScore) {
            Utils.checkNotNull(addressScore, "addressScore");
            this.addressScore = addressScore;
            return this;
        }

        public Builder city(boolean city) {
            Utils.checkNotNull(city, "city");
            this.city = Optional.ofNullable(city);
            return this;
        }

        public Builder city(Optional<Boolean> city) {
            Utils.checkNotNull(city, "city");
            this.city = city;
            return this;
        }

        public Builder distance(double distance) {
            Utils.checkNotNull(distance, "distance");
            this.distance = Optional.ofNullable(distance);
            return this;
        }

        public Builder distance(Optional<Double> distance) {
            Utils.checkNotNull(distance, "distance");
            this.distance = distance;
            return this;
        }

        public Builder postalCode(boolean postalCode) {
            Utils.checkNotNull(postalCode, "postalCode");
            this.postalCode = Optional.ofNullable(postalCode);
            return this;
        }

        public Builder postalCode(Optional<Boolean> postalCode) {
            Utils.checkNotNull(postalCode, "postalCode");
            this.postalCode = postalCode;
            return this;
        }

        public Builder region(boolean region) {
            Utils.checkNotNull(region, "region");
            this.region = Optional.ofNullable(region);
            return this;
        }

        public Builder region(Optional<Boolean> region) {
            Utils.checkNotNull(region, "region");
            this.region = region;
            return this;
        }

        public Builder street(boolean street) {
            Utils.checkNotNull(street, "street");
            this.street = Optional.ofNullable(street);
            return this;
        }

        public Builder street(Optional<Boolean> street) {
            Utils.checkNotNull(street, "street");
            this.street = street;
            return this;
        }

        public Builder streetNumber(long streetNumber) {
            Utils.checkNotNull(streetNumber, "streetNumber");
            this.streetNumber = Optional.ofNullable(streetNumber);
            return this;
        }

        public Builder streetNumber(Optional<Long> streetNumber) {
            Utils.checkNotNull(streetNumber, "streetNumber");
            this.streetNumber = streetNumber;
            return this;
        }
        
        public DataSourceAddressResponseInternal build() {
            return new DataSourceAddressResponseInternal(
                addressScore,
                city,
                distance,
                postalCode,
                region,
                street,
                streetNumber);
        }
    }
}

