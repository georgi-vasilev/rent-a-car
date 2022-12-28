package com.group.carrentalserver.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.group.carrentalserver.domain.enumeration.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DealerDto.class, name = "dealer"),
        @JsonSubTypes.Type(value = TenantDto.class, name = "tenant"),
        @JsonSubTypes.Type(value = CombinedUserDto.class, name = "combined"),
})
public class UserDto {
    private String username;
    private String email;
    private UserStatus status;
    private Set<RoleDto> roles = new HashSet<>();
}
