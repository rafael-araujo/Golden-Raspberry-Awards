package com.example.demo.integration;

import com.example.demo.loader.CsvDatabaseLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationAPITest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testMovieApi() {

        CsvDatabaseLoader loader = context.getBean(CsvDatabaseLoader.class);

        loader.processCsvAndSave("/database/movielist.csv");

        String url = "http://localhost:" + port + "/api/movie-awards/intervals";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(response.getBody(), "{\"min\":[{\"producer\":\"Charles B. Wessler\",\"interval\":0,\"previousWin\":2013,\"followingWin\":2013},{\"producer\":\"Bob Cavallo\",\"interval\":0,\"previousWin\":1986,\"followingWin\":1986},{\"producer\":\"Andrew G. Vajna\",\"interval\":0,\"previousWin\":2006,\"followingWin\":2006},{\"producer\":\"Michelle Raimo Kouyate\",\"interval\":0,\"previousWin\":2017,\"followingWin\":2017},{\"producer\":\"Kimberley Kates\",\"interval\":0,\"previousWin\":2005,\"followingWin\":2005},{\"producer\":\"Carol Baum\",\"interval\":0,\"previousWin\":1992,\"followingWin\":1992},{\"producer\":\"Frank Yablans\",\"interval\":0,\"previousWin\":1981,\"followingWin\":1981},{\"producer\":\"Kevin Costner\",\"interval\":0,\"previousWin\":1997,\"followingWin\":1997},{\"producer\":\"Jimmy Miller\",\"interval\":0,\"previousWin\":2018,\"followingWin\":2018},{\"producer\":\"Steven Perry\",\"interval\":0,\"previousWin\":1990,\"followingWin\":1990},{\"producer\":\"Robert W. Cort\",\"interval\":0,\"previousWin\":1988,\"followingWin\":1988},{\"producer\":\"Ted Field\",\"interval\":0,\"previousWin\":1988,\"followingWin\":1988},{\"producer\":\"Mario Kassar\",\"interval\":0,\"previousWin\":2006,\"followingWin\":2006},{\"producer\":\"Bo Derek\",\"interval\":0,\"previousWin\":1984,\"followingWin\":1984},{\"producer\":\"Bo Derek\",\"interval\":0,\"previousWin\":1990,\"followingWin\":1990},{\"producer\":\"Gregory Goodman\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"Raphi Henley\",\"interval\":0,\"previousWin\":2014,\"followingWin\":2014},{\"producer\":\"Joe Eszterhas\",\"interval\":0,\"previousWin\":1998,\"followingWin\":1998},{\"producer\":\"Joel B. Michaels\",\"interval\":0,\"previousWin\":2006,\"followingWin\":2006},{\"producer\":\"Michael De Luca\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"Trent Walford\",\"interval\":0,\"previousWin\":2005,\"followingWin\":2005},{\"producer\":\"Jonathan D. Krane\",\"interval\":0,\"previousWin\":2000,\"followingWin\":2000},{\"producer\":\"Andrew Bergman\",\"interval\":0,\"previousWin\":1996,\"followingWin\":1996},{\"producer\":\"John Mallory Asher\",\"interval\":0,\"previousWin\":2005,\"followingWin\":2005},{\"producer\":\"Edward McDonnell\",\"interval\":0,\"previousWin\":2004,\"followingWin\":2004},{\"producer\":\"Steve Fargnoli\",\"interval\":0,\"previousWin\":1986,\"followingWin\":1986},{\"producer\":\"Tom DeSanto\",\"interval\":0,\"previousWin\":2009,\"followingWin\":2009},{\"producer\":\"Denise Di Novi\",\"interval\":0,\"previousWin\":2004,\"followingWin\":2004},{\"producer\":\"Gerald R. Molen\",\"interval\":0,\"previousWin\":2016,\"followingWin\":2016},{\"producer\":\"Amanda Rosser\",\"interval\":0,\"previousWin\":2014,\"followingWin\":2014},{\"producer\":\"BJ Davis\",\"interval\":0,\"previousWin\":2005,\"followingWin\":2005},{\"producer\":\"Charles Evans\",\"interval\":0,\"previousWin\":1995,\"followingWin\":1995},{\"producer\":\"Buzz Feitshans\",\"interval\":0,\"previousWin\":1985,\"followingWin\":1985},{\"producer\":\"Buzz Feitshans\",\"interval\":0,\"previousWin\":1994,\"followingWin\":1994},{\"producer\":\"Joe Ruffalo\",\"interval\":0,\"previousWin\":1986,\"followingWin\":1986},{\"producer\":\"Karen Rosenfelt\",\"interval\":0,\"previousWin\":2012,\"followingWin\":2012},{\"producer\":\"Wyck Godfrey\",\"interval\":0,\"previousWin\":2012,\"followingWin\":2012},{\"producer\":\"Mitsuharu Ishii\",\"interval\":0,\"previousWin\":1982,\"followingWin\":1982},{\"producer\":\"Kathleen Kennedy\",\"interval\":0,\"previousWin\":2010,\"followingWin\":2010},{\"producer\":\"Michael Manasseri\",\"interval\":0,\"previousWin\":2005,\"followingWin\":2005},{\"producer\":\"Robert R. Weston\",\"interval\":0,\"previousWin\":1983,\"followingWin\":1983},{\"producer\":\"Jenny McCarthy\",\"interval\":0,\"previousWin\":2005,\"followingWin\":2005},{\"producer\":\"Howard Lapides\",\"interval\":0,\"previousWin\":2001,\"followingWin\":2001},{\"producer\":\"Mike Myers\",\"interval\":0,\"previousWin\":2008,\"followingWin\":2008},{\"producer\":\"Lorenzo di Bonaventura\",\"interval\":0,\"previousWin\":2009,\"followingWin\":2009},{\"producer\":\"John Travolta\",\"interval\":0,\"previousWin\":2000,\"followingWin\":2000},{\"producer\":\"Stephenie Meyer\",\"interval\":0,\"previousWin\":2012,\"followingWin\":2012},{\"producer\":\"Dana Brunetti\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"Eric Fellner\",\"interval\":0,\"previousWin\":2019,\"followingWin\":2019},{\"producer\":\"Hutch Parker\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"Todd Garner\",\"interval\":0,\"previousWin\":2011,\"followingWin\":2011},{\"producer\":\"Michael DeLuca\",\"interval\":0,\"previousWin\":2008,\"followingWin\":2008},{\"producer\":\"Peter Farrelly\",\"interval\":0,\"previousWin\":2013,\"followingWin\":2013},{\"producer\":\"Frank Marshall\",\"interval\":0,\"previousWin\":2010,\"followingWin\":2010},{\"producer\":\"Ryan Kavanaugh\",\"interval\":0,\"previousWin\":2013,\"followingWin\":2013},{\"producer\":\"Will Ferrell\",\"interval\":0,\"previousWin\":2018,\"followingWin\":2018},{\"producer\":\"Matthew Vaughn\",\"interval\":0,\"previousWin\":2002,\"followingWin\":2002},{\"producer\":\"Matthew Vaughn\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"Steve Tisch\",\"interval\":0,\"previousWin\":1997,\"followingWin\":1997},{\"producer\":\"Larry Brezner\",\"interval\":0,\"previousWin\":2001,\"followingWin\":2001},{\"producer\":\"Joel Silver\",\"interval\":0,\"previousWin\":1990,\"followingWin\":1990},{\"producer\":\"Joel Silver\",\"interval\":0,\"previousWin\":1991,\"followingWin\":1991},{\"producer\":\"Sam Mercer\",\"interval\":0,\"previousWin\":2010,\"followingWin\":2010},{\"producer\":\"Martin Brest\",\"interval\":0,\"previousWin\":2003,\"followingWin\":2003},{\"producer\":\"Howard Rosenman\",\"interval\":0,\"previousWin\":1992,\"followingWin\":1992},{\"producer\":\"Adam McKay\",\"interval\":0,\"previousWin\":2018,\"followingWin\":2018},{\"producer\":\"Harve Bennett\",\"interval\":0,\"previousWin\":1989,\"followingWin\":1989},{\"producer\":\"David Matalon\",\"interval\":0,\"previousWin\":1994,\"followingWin\":1994},{\"producer\":\"Elie Samaha\",\"interval\":0,\"previousWin\":2000,\"followingWin\":2000},{\"producer\":\"Darren Doane\",\"interval\":0,\"previousWin\":2014,\"followingWin\":2014},{\"producer\":\"Bill Cosby\",\"interval\":0,\"previousWin\":1987,\"followingWin\":1987},{\"producer\":\"Jon Peters\",\"interval\":0,\"previousWin\":1999,\"followingWin\":1999},{\"producer\":\"and Tom Hooper\",\"interval\":0,\"previousWin\":2019,\"followingWin\":2019},{\"producer\":\"Simon Kinberg\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"Gary Barber\",\"interval\":0,\"previousWin\":2008,\"followingWin\":2008},{\"producer\":\"Allan Carr\",\"interval\":0,\"previousWin\":1980,\"followingWin\":1980},{\"producer\":\"Barry Sonnenfeld\",\"interval\":0,\"previousWin\":1999,\"followingWin\":1999},{\"producer\":\"Ben Myron\",\"interval\":0,\"previousWin\":1998,\"followingWin\":1998},{\"producer\":\"Jim Wilson\",\"interval\":0,\"previousWin\":1997,\"followingWin\":1997},{\"producer\":\"Alan Marshall\",\"interval\":0,\"previousWin\":1995,\"followingWin\":1995},{\"producer\":\"E. L. James\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"John Penotti\",\"interval\":0,\"previousWin\":2013,\"followingWin\":2013},{\"producer\":\"Gloria Katz\",\"interval\":0,\"previousWin\":1986,\"followingWin\":1986},{\"producer\":\"Mike Lobell\",\"interval\":0,\"previousWin\":1996,\"followingWin\":1996},{\"producer\":\"Clayton Townsend\",\"interval\":0,\"previousWin\":2018,\"followingWin\":2018},{\"producer\":\"Robert Kulzer\",\"interval\":0,\"previousWin\":2015,\"followingWin\":2015},{\"producer\":\"Rod Hamilton\",\"interval\":0,\"previousWin\":2005,\"followingWin\":2005},{\"producer\":\"David Shannon\",\"interval\":0,\"previousWin\":2014,\"followingWin\":2014},{\"producer\":\"Casey Silver\",\"interval\":0,\"previousWin\":2003,\"followingWin\":2003},{\"producer\":\"Adam Sandler\",\"interval\":0,\"previousWin\":2011,\"followingWin\":2011},{\"producer\":\"Debra Hayward\",\"interval\":0,\"previousWin\":2019,\"followingWin\":2019},{\"producer\":\"Ian Bryce\",\"interval\":0,\"previousWin\":2009,\"followingWin\":2009},{\"producer\":\"Don Murphy\",\"interval\":0,\"previousWin\":2009,\"followingWin\":2009},{\"producer\":\"Jack Giarraputo\",\"interval\":0,\"previousWin\":2011,\"followingWin\":2011},{\"producer\":\"M. Night Shyamalan\",\"interval\":0,\"previousWin\":2010,\"followingWin\":2010},{\"producer\":\"Sherry Lansing\",\"interval\":0,\"previousWin\":1993,\"followingWin\":1993},{\"producer\":\"Lauren Lloyd\",\"interval\":0,\"previousWin\":2001,\"followingWin\":2001},{\"producer\":\"Tim Bevan\",\"interval\":0,\"previousWin\":2019,\"followingWin\":2019}],\"max\":[{\"producer\":\"Matthew Vaughn\",\"interval\":13,\"previousWin\":2002,\"followingWin\":2015}]}");
    }
}
