package ga.rugal.amazon.findcommand;

import lombok.Data;

@Data
public class Predicate {

  private String name;

  private String extension;

  private Integer minimum;

  private Integer maximum;
}
