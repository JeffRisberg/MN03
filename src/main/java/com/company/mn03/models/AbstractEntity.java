package com.company.mn03.models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * @author Jeff Risberg
 * @since 10/22/17
 */
@Data
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;
}
