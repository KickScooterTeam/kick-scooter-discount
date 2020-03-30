package com.example.demo.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "bonus")
public class BonusModel {

        @Id
        private Long id;
        private String name;
        private Date startDate;
        private Date endDate;
        private UUID userid;
        private int bonus;
        private boolean active;

        @Override
        public String toString() {
            return "Bonus [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
                    + "bonus=" + bonus + "]";
        }


}
