public class Codec {

    Map<String,Integer> map1 = new HashMap<>();
    Map<Integer,String> map2 = new HashMap<>();
    Integer count=0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(map1.containsKey(longUrl))
            return map1.get(longUrl).toString();
        map1.put(longUrl,count);
        map2.put(count,longUrl);
        return count.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map2.get(Integer.parseInt(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));