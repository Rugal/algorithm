package ga.rugal.amazon.findcommand;

import lombok.Value;

@Value
public class NameFilter implements Filter {

  String name;

  @Override
  public boolean apply(final File file) {
    return file.getName().contains(this.name);
  }
}
