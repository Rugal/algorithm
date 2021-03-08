package ga.rugal.amazon.findcommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearcher {

  public List<File> find(final File root, final List<Filter> filters) {
    if (!root.isDirectory()) {
      throw new NotDirectoryException(root.getName());
    }

    final List<File> result = new ArrayList<>();
    final Queue<File> queue = new LinkedList<>(Arrays.asList(root.getChildren()));
    while (!queue.isEmpty()) {
      final var poll = queue.poll();
      if (poll.isDirectory()) {
        queue.addAll(Arrays.asList(root.getChildren()));
      } else {
        // TODO: better to have a boolean operator that connect each filter
        // but now we assume it is &&, meaning target file must meet all requirements
        var optional = filters.stream().map(f -> f.apply(poll)).reduce(Boolean::logicalAnd);
        if (optional.orElse(false)) {
          result.add(poll);
        }
      }
    }
    return result;
  }
}
