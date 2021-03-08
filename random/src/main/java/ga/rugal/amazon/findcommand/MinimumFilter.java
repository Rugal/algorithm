package ga.rugal.amazon.findcommand;

import lombok.Data;

@Data
public class MinimumFilter implements Filter {

  int minimum;

  @Override
  public boolean apply(final File file) {
    return file.getSize() >= this.minimum;
  }
}
