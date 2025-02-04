public class Codec {
      private Map<Integer, String> map = new HashMap<>();
      private int index;
      // Encodes a URL to a shortened URL.
      public String encode(String longUrl) {
          int key = longUrl.hashCode();
          this.map.put(key, longUrl);
          return "http://tinyurl.com/" + longUrl.hashCode();
      }

      // Decodes a shortened URL to its original URL.
      public String decode(String shortUrl) {
          return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
      }
  }