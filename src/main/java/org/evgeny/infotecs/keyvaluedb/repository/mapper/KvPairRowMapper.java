package org.evgeny.infotecs.keyvaluedb.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.evgeny.infotecs.keyvaluedb.model.KvPair;
import org.evgeny.infotecs.keyvaluedb.model.ValueWithExpirationTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KvPairRowMapper implements RowMapper<KvPair> {
    @Override
    public KvPair mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new KvPair(rs.getString("KEY"),
                new ValueWithExpirationTime(
                        rs.getString("VALUE"),
                        rs.getTimestamp("EXPIRATION_TIME").getTime()));
    }
}
