package ga.rugal.amazon.findcommand;

import lombok.Value;

@Value
public class ExtensionFilter implements Filter {

  String extension;

  @Override
  public boolean apply(final File file) {
    return this.extension.equals(file.getExtension());
  }
}
