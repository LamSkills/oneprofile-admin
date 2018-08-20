package com.newlight77.admin.model;

import com.newlight77.admin.neo4j.RoleEntity;
import com.newlight77.right.model.Right;
import com.newlight77.right.model.TemporaryRight;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Set;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class RightDto {
  @NotEmpty
  private String primary;
  @NotEmpty
  private String secondary;
  private Set<Right> rights;
  private Set<TemporaryRight> tempRights;
  private Instant modificationDate;
  private RoleEntity role;
}
