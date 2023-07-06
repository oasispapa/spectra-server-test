package com.spectra.Spectra;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString(callSuper = true)
public class ReqDto {

    private String authId;
    private Cmd cmd;
    @Builder
    @Data
    public static class Cmd {
        private String sessionKey;
        private String message;
        private String command;
        private String subcommands;
        private String domainId;
        private String serviceType;
        private String parentId;
        private String nodeId;
    }
}
