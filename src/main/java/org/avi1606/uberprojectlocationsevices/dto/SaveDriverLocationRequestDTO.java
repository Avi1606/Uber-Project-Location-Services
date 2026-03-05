package org.avi1606.uberprojectlocationsevices.dto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveDriverLocationRequestDTO {

     String driverId;

     Double longitude;

     Double latitude;



}
