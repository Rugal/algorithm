package ga.rugal.amazon.findcommand;

import lombok.Value;

@Value
public class MaximumFilter implements Filter {

  int maximum;

  @Override
  public boolean apply(final File file) {
    return file.getSize() <= this.maximum;
  }
}
