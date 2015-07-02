package com.easyrent.webapp.persistance.entity;

import com.easyrent.webapp.validator.Phone;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author sabir.salman
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rental extends Persistent implements Serializable {

    @NotEmpty
    @Column(nullable = false, name = "TITLE")
    @Size(min = 1, max = 100)
    private String title;

    @NotEmpty
    @Column(nullable = false, name = "DESCRIPTION")
    @Size(min = 5, max = 500)
    private String description;

    @NotNull
    @Column(nullable = false, name = "CATEGORY_ID")
    private Integer category;

    @NotNull
    @Column(nullable = false, name = "RENT")
    @Range(min = 0)
    private Integer rent;

    @NotNull
    @Column(nullable = false, name = "SIZE")
    @Range(min = 100, max = 50000)
    private Integer size;

    @NotEmpty
    @Column(nullable = false, name = "ADVANCE_PERIOD")
    private String advancePeriod;

    @NotEmpty
    @Column(nullable = false, name = "NOTICE_PERIOD")
    private String noticePeriod;

    @NotNull
    @Column(nullable = false, name = "SERVICE_CHARGE")
    @Range(min = 0)
    private Integer serviceCharge;

    @Column(name = "CAR_PARKING", columnDefinition = "boolean default false", nullable = false)
    private boolean carParking = false;

    @Column(name = "GENERATOR_FACILITY", columnDefinition = "boolean default false", nullable = false)
    private boolean generatorFacility = false;

    @Column(name = "LIFT_FACILITY", columnDefinition = "boolean default false", nullable = false)
    private boolean liftFacility = false;

    @Column(name = "GAS_SUPPLY", columnDefinition = "boolean default false", nullable = false)
    private boolean gasSupply = false;

    @NotNull
    @Embedded
    private Address address;

    @NotEmpty
    @Column(name = "MOBILE_ONE", nullable = false)
    @Phone
    private String mobileOne;

    @Column(name = "MOBILE_TWO", nullable = true)
    @Phone
    private String mobileTwo;

    @Lob
    @Column(name = "IMAGE_ONE", nullable = false)
    private byte[] imageOne;

    @Lob
    @Column(name = "IMAGE_TWO", nullable = true)
    private byte[] imageTwo;

    @Lob
    @Column(name = "IMAGE_THREE", nullable = true)
    private byte[] imageThree;

    @NotNull
    @Column(name = "AVERAGE_RATING", nullable = true, columnDefinition = "int default 0")
    private int averageRating;

    @NotNull
    @Column(name = "LATITUDE", nullable = false)
    private String latitude;

    @NotNull
    @Column(name = "LONGITUDE", nullable = false)
    private String longitude;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isGasSupply() {
        return gasSupply;
    }

    public void setGasSupply(boolean gasSupply) {
        this.gasSupply = gasSupply;
    }

    public String getAdvancePeriod() {
        return advancePeriod;
    }

    public void setAdvancePeriod(String advancePeriod) {
        this.advancePeriod = advancePeriod;
    }

    public Integer getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Integer serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public boolean isCarParking() {
        return carParking;
    }

    public void setCarParking(boolean carParking) {
        this.carParking = carParking;
    }

    public boolean isGeneratorFacility() {
        return generatorFacility;
    }

    public void setGeneratorFacility(boolean generatorFacility) {
        this.generatorFacility = generatorFacility;
    }

    public boolean isLiftFacility() {
        return liftFacility;
    }

    public void setLiftFacility(boolean liftFacility) {
        this.liftFacility = liftFacility;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public String getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        if (latitude.contains(",")) {
            this.latitude = latitude.split(",")[1];
        } else {
            this.latitude = latitude;
        }
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        if (longitude.contains(",")) {
            this.longitude = longitude.split(",")[1];
        } else {
            this.longitude = longitude;
        }
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMobileOne() {
        return mobileOne;
    }

    public void setMobileOne(String mobileOne) {
        this.mobileOne = mobileOne;
    }

    public String getMobileTwo() {
        return mobileTwo;
    }

    public void setMobileTwo(String mobileTwo) {
        this.mobileTwo = mobileTwo;
    }

    public byte[] getImageOne() {
        return imageOne;
    }

    public void setImageOne(byte[] imageOne) {
        this.imageOne = imageOne;
    }

    public byte[] getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(byte[] imageTwo) {
        this.imageTwo = imageTwo;
    }

    public byte[] getImageThree() {
        return imageThree;
    }

    public void setImageThree(byte[] imageThree) {
        this.imageThree = imageThree;
    }

    public void update(Rental rental) {
        this.setTitle(rental.getTitle());
        this.setDescription(rental.getDescription());
        this.getAddress().setAddressLine(rental.getAddress().getAddressLine());
        this.getAddress().setArea(rental.getAddress().getArea());
        this.setCategory(rental.getCategory());
        this.setRent(rental.getRent());
        this.setSize(rental.getSize());
        this.setAdvancePeriod(rental.getAdvancePeriod());
        this.setNoticePeriod(rental.getNoticePeriod());
        this.setServiceCharge(rental.getServiceCharge());
        this.setCarParking(rental.isCarParking());
        this.setGasSupply(rental.isGasSupply());
        this.setGeneratorFacility(rental.isGeneratorFacility());
        this.setLiftFacility(rental.isLiftFacility());
        this.setMobileOne(rental.getMobileOne());
        this.setLatitude(rental.getLatitude());
        this.setLongitude(rental.getLongitude());

        if (rental.getMobileTwo() != null) {
            this.setMobileTwo(rental.getMobileTwo());
        }
        if (rental.getImageOne() != null) {
            this.setImageOne(rental.getImageOne());
        }
        if (rental.getImageTwo() != null) {
            this.setImageTwo(rental.getImageTwo());
        }
        if (rental.getImageThree() != null) {
            this.setImageThree(rental.getImageThree());
        }
    }

    public void updateAverageRating(Review review) {
        if (this.getReviews().size() == 1) {
            this.setAverageRating(review.getRating());
        } else {
            float average = (this.getAverageRating() + review.getRating()) / 2;
            this.setAverageRating(Math.round(average));
        }
    }
}
