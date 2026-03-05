package org.avi1606.uberprojectlocationsevices.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLocationDTO {
    String DriverId;

    Double latitude;

    Double longitude;
}
