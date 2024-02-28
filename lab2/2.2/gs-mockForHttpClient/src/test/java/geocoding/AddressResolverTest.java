package geocoding;

import connection.TqsBasicHttpClient;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock
    TqsBasicHttpClient httpClient = mock(TqsBasicHttpClient.class);

    AddressResolverService resolver;

    @Test
    void whenResolveDetiGps_returnJacintoMagalhaeAddress() throws ParseException, IOException, URISyntaxException {

        this.resolver = new AddressResolverService(httpClient);

        // todo: implement test; remove Disabled annotation

        String staticResponse = "{\n" + //
                "  \"info\": {\n" + //
                "    \"statuscode\": 0,\n" + //
                "    \"copyright\": {\n" + //
                "      \"text\": \"© 2024 MapQuest, Inc.\",\n" + //
                "      \"imageUrl\": \"http://api.mqcdn.com/res/mqlogo.gif\",\n" + //
                "      \"imageAltText\": \"© 2024 MapQuest, Inc.\"\n" + //
                "    },\n" + //
                "    \"messages\": []\n" + //
                "  },\n" + //
                "  \"options\": {\n" + //
                "    \"maxResults\": 1,\n" + //
                "    \"ignoreLatLngInput\": false\n" + //
                "  },\n" + //
                "  \"results\": [\n" + //
                "    {\n" + //
                "      \"providedLocation\": {\n" + //
                "        \"latLng\": {\n" + //
                "          \"lat\": 40.63436,\n" + //
                "          \"lng\": -8.65616\n" + //
                "        }\n" + //
                "      },\n" + //
                "      \"locations\": [\n" + //
                "        {\n" + //
                "          \"street\": \"Avenida da Universidade\",\n" + //
                "          \"adminArea6\": \"Aveiro\",\n" + //
                "          \"adminArea6Type\": \"Neighborhood\",\n" + //
                "          \"adminArea5\": \"Aveiro\",\n" + //
                "          \"adminArea5Type\": \"City\",\n" + //
                "          \"adminArea4\": \"Aveiro\",\n" + //
                "          \"adminArea4Type\": \"County\",\n" + //
                "          \"adminArea3\": \"\",\n" + //
                "          \"adminArea3Type\": \"State\",\n" + //
                "          \"adminArea1\": \"PT\",\n" + //
                "          \"adminArea1Type\": \"Country\",\n" + //
                "          \"postalCode\": \"3810-489\",\n" + //
                "          \"geocodeQualityCode\": \"B1AAA\",\n" + //
                "          \"geocodeQuality\": \"STREET\",\n" + //
                "          \"dragPoint\": false,\n" + //
                "          \"sideOfStreet\": \"L\",\n" + //
                "          \"linkId\": \"0\",\n" + //
                "          \"unknownInput\": \"\",\n" + //
                "          \"type\": \"s\",\n" + //
                "          \"latLng\": {\n" + //
                "            \"lat\": 40.63437,\n" + //
                "            \"lng\": -8.65625\n" + //
                "          },\n" + //
                "          \"displayLatLng\": {\n" + //
                "            \"lat\": 40.63437,\n" + //
                "            \"lng\": -8.65625\n" + //
                "          },\n" + //
                "          \"mapUrl\": \"\"\n" + //
                "        }\n" + //
                "      ]\n" + //
                "    }\n" + //
                "  ]\n" + //
                "}";

        when(httpClient.doHttpGet(anyString())).thenReturn(staticResponse);

        // will crash for now...need to set the resolver before using it
        Optional<Address> result = resolver.findAddressForLocation(40.63436, -8.65616);

        // return
        Address expected = new Address("Avenida da Universidade", "Aveiro", "3810-489", "");

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());

    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddress() throws IOException, URISyntaxException, ParseException {

        /// todo: implement test
        this.resolver = new AddressResolverService(httpClient);

        String api_resp = "{\n" +
                "  \"info\": {\n" +
                "    \"statuscode\": 0,\n" +
                "    \"copyright\": {\n" +
                "      \"text\": \"© 2024 MapQuest, Inc.\",\n" +
                "      \"imageUrl\": \"https://api.mqcdn.com/res/mqlogo.gif\",\n" +
                "      \"imageAltText\": \"© 2024 MapQuest, Inc.\"\n" +
                "    },\n" +
                "    \"messages\": []\n" +
                "  },\n" +
                "  \"options\": {\n" +
                "    \"maxResults\": 1,\n" +
                "    \"thumbMaps\": true,\n" +
                "    \"ignoreLatLngInput\": false\n" +
                "  },\n" +
                "  \"results\":[{\n" +
                "    \"providedLocation\": {\n" +
                "      \"latLng\": {\n" +
                "        \"lat\": 30.333472,\n" +
                "        \"lng\": -81.470448\n" +
                "      }\n" +
                "    },\n" +
                "    \"locations\": []\n" +
                "  }\n" +
                "]\n" +
                "}";

        when(httpClient.doHttpGet(anyString())).thenReturn(api_resp);

        Optional<Address> result = resolver.findAddressForLocation(-361, -361);

        // verify no valid result
        assertFalse(result.isPresent());

    }
}