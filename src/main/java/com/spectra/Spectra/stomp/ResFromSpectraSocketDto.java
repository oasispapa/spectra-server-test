package com.spectra.Spectra.stomp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResFromSpectraSocketDto {
    private String eventId;
    private String talkId;
    private String serviceType;
    private String updatedBy;
    private String value;
    private String paramMap;
}
