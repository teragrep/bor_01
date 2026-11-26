package com.teragrep.bor_01;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class BytesHash implements Hashable {
    private final Byteable origin;

    public BytesHash(final Byteable origin) {
        this.origin = origin;
    }

    @Override
    public byte[] asHash() {
        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-512");
        } catch (final NoSuchAlgorithmException e) {
            throw new RuntimeException("BytesHash could not create the hash", e);
        }
        return digest.digest(origin.bytes());
    }
}
