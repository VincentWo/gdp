public class Caesar {
  static String caesar(int k, String msg) {
    // These are the character ranges that are rotated
    // Note that they may not overlap
    char[][] ranges = {
      {'a', 'z'},
      {'A', 'Z'}
    };
    char[] chars = msg.toCharArray();
    for (var i = 0; i < chars.length; i++) {
      for (var range : ranges) {
        // Only transform if in range
        if (range[0] <= chars[i] && chars[i] <= range[1]) {
          // We calculate the offset from the start and then use modulo
          // to rotate around
          var offset = chars[i] - range[0];
          var rotated = (offset + k) % (range[1] - range[0] + 1);
          chars[i] = (char)(range[0] + rotated);
        }
      }
    }
    return new String(chars);
  }
  public static void main(String[] args) {
    var k = Integer.parseInt(args[0]);
    var messages = java.util.Arrays.copyOfRange(args, 1, args.length);
    for (var message : messages) {
      System.out.println(caesar(k, message));
    }
  }
}
