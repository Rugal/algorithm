package ga.rugal.amazon.findcommand;

import lombok.Data;

@Data
public class File {

  private boolean isDirectory;

  private int size;

  private String name;

  private String extension;

  private File[] children;
}
