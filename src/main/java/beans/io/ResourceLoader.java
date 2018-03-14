package beans.io;

import java.net.URL;

public class ResourceLoader {
    public Resource getRsource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
