package org.example.Repositories;

import org.example.Models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private static Map<Long, Gate> gatesMap = new HashMap<>();
    private Long prevId = Long.valueOf(0);

    public GateRepository() {
        int noOfGates = 10;
        for (int i = 0; i < noOfGates; i++) {
            if (i < 5) {
                Gate gate = new Gate((i+1), GateType.ENTRY_GATE,
                        new Operator(("O" + String.valueOf(i+1)), ("Operator" + String.valueOf(i+1))));

                gate.setId(Long.valueOf(i+1));
                gatesMap.put(Long.valueOf(i+1), gate);
            }
            else {

                Gate gate = new Gate((i+1), GateType.EXIT_GATE,
                        new Operator(("O" + String.valueOf(i+1)), ("Operator" + String.valueOf(i+1))));

                gate.setId(Long.valueOf(i+1));
                gatesMap.put(Long.valueOf(i+1), gate);
            }
        }
    }

    public Optional<Gate> findByGateId (Long gateId) {
        if (gatesMap.containsKey(gateId)) {
            return Optional.of(gatesMap.get(gateId));
        }
        return Optional.empty();
    }

    public void saveGate (Gate gate) {
        prevId = prevId + 1;
        gate.setId(prevId);
        gatesMap.put(prevId, gate);
    }

    public static Map<Long, Gate> getGatesMap() {
        return gatesMap;
    }

}
