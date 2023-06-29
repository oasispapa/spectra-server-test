package com.spectra.Spectra;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpectraCounselDto {
    private String sessionKey;
    private SpectraResponse data;

    @Data
    @Builder
    public static class SpectraResponse {
        private String talkId;
        private int seq;
        private String type;
        private String msg;
        private String sender;
        private String accountId;
        private String flag;
        private String agentReadFlag;
        private String customerReadFlag;
        private String cdate;
        private String ext;
        private String fileName;
    }

}
