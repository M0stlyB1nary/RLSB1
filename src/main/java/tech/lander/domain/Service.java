package tech.lander.domain;

import io.swagger.annotations.ApiModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@ApiModel(description="This is an instsance of a maintenance performed")
@Document(collection = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date serviceDate;
    private int serviceMileage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public int getServiceMileage() {
        return serviceMileage;
    }

    public void setServiceMileage(int serviceMileage) {
        this.serviceMileage = serviceMileage;
    }




}
