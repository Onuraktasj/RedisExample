package com.redis.RedisExample.dto.entitiy;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class CategoryDto implements Serializable {

    private UUID id;
    private String name;
}
