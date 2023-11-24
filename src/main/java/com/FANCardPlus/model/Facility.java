package com.FANCardPlus.model;
import javax.persistence.*;

@Entity
@Table(name = "Facilities", schema="dbo")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facilities_ID")
    private Long facilityId;

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    ///

    @Column(name = "name", length = 150)
    private String facilityName;

    public String getFacilityName() {
        return facilityName;
    }

    public void setTransactionCategoryName(String facilityName) {
        this.facilityName = facilityName;
    }
    
    ///

    @Column(name = "description", columnDefinition = "text")
    private String facilityDescription;

    public String getFacilityDescription() {
        return facilityDescription;
    }

    public void setFacilityDescription(String facilityDescription) {
        this.facilityDescription = facilityDescription;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission; 

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}