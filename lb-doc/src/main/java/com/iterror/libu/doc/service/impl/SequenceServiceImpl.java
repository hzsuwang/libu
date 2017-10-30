package com.iterror.libu.doc.service.impl;

import com.iterror.libu.common.service.BaseService;
import com.iterror.libu.doc.service.SequenceService;
import com.iterror.libu.domain.SequenceDO;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tony.yan on 2017/10/29.
 */
@Service("sequenceService")
public class SequenceServiceImpl extends BaseService implements SequenceService {

    private static final String seqBuyOrderName  = "seq_buy_order_id";

    private static AtomicLong   maxBuyOrderSeqId = new AtomicLong(0);
    private static AtomicLong   curBuyOrderSeqId = new AtomicLong(0);


    @Override
    public long getBuyOrderId() {
        if (maxBuyOrderSeqId.longValue() == 0 || curBuyOrderSeqId.longValue() == 0) {
            flushSqeValue(seqBuyOrderName);
            long value = getNewSeqValue(seqBuyOrderName);
            maxBuyOrderSeqId.set(value);
            curBuyOrderSeqId.set(value - 1000);
        }
        curBuyOrderSeqId.getAndIncrement();
        return curBuyOrderSeqId.longValue();
    }

    private long getNewSeqValue(String seqName) {
        SequenceDO sequenceDO = dao.fetch(SequenceDO.class, Cnd.where("seq_name","=",seqName));
        return sequenceDO.getSeqValue();
    }

    private void flushSqeValue(String seqName) {
        Sql sql = Sqls.create("update qk_sequence set edit_time = now(), seq_value = seq_value + seq_cache_value $condition");
        sql.setCondition(Cnd.where("seq_name","=",seqName));
        dao.execute(sql);
    }
}
