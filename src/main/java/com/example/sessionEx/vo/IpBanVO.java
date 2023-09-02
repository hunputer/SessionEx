package com.example.sessionEx.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class IpBanVO {

    private String ip;
    private Date insertDate;

}
