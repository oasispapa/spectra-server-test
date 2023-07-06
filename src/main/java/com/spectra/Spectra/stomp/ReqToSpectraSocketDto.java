package com.spectra.Spectra.stomp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqToSpectraSocketDto {
    private String user;
    private Status status;
    @AllArgsConstructor
    @Getter
    public enum Status {

        ASSOCIATE("associate","일반메시지"),
        DISASSOCIATE("disassociate","첨부파일 URL");
        private final String code;
        private final String description;
    }
}
