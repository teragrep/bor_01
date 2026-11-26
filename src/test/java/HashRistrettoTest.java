import com.goterl.lazysodium.LazySodiumJava;
import com.goterl.lazysodium.SodiumJava;
import com.goterl.lazysodium.interfaces.Ristretto255;
import com.teragrep.bor_01.BytesHash;
import com.teragrep.bor_01.HashRistretto;
import com.teragrep.bor_01.JsonBytes;
import com.teragrep.bor_01.aip.BloomFilter;
import com.teragrep.bor_01.aip.BloomFilterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

final class HashRistrettoTest {
    @Test
    void testWithBloomFilter() {
        final BloomFilter bloomFilter = new BloomFilterImpl(
                new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Pattern.compile(".*"), 1000L, 123.4d
        );

        final JsonBytes bloomJsonBytes = new JsonBytes(bloomFilter);
        final BytesHash bloomBytesHash = new BytesHash(bloomJsonBytes);
        final LazySodiumJava ls = new LazySodiumJava(new SodiumJava());
        final HashRistretto bloomRistretto = new HashRistretto(ls,bloomBytesHash);
        final Ristretto255.RistrettoPoint point = bloomRistretto.asPoint();
        Assertions.assertEquals("CCB87FD7E4E454C22AA9C5084567BF818C2B0D485AE82CB55F0BA8676979BB3C", point.toHex());
        Assertions.assertTrue(ls.cryptoCoreRistretto255IsValidPoint(point.toBytes()));
    }
}
