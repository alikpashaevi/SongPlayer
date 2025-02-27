package springdemo_4.springdemo_4.constants;

public class AuthorizationConstants {

    public static final String ADMIN = "hasAuthority('ROLE_ADMIN)";
    public static final String USER_OR_ARTIST_OR_ADMIN = "hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_ARTIST')";
    public static final String ARTIST_OR_ADMIN = "hasAuthority('ROLE_ARTIST') or hasAuthority('ROLE_ADMIN')";
}
