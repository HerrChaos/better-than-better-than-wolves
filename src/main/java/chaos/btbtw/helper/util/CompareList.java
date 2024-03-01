package chaos.btbtw.helper.util;


import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompareList {
    List<String> IdentifierList = new ArrayList<>();
    List<Object> OutputList = new ArrayList<>();
    public CompareList() {

    }

    public void add(String identifier, Object entry, @Nullable Integer index) {
        if (index == null) {
            index = this.IdentifierList.size();
            this.IdentifierList.add(index, identifier);
            this.OutputList.add(index, entry);
            return;
        }
        if (this.IdentifierList.get(index).isEmpty()) {
            this.IdentifierList.add(index, identifier);
            this.OutputList.add(index, entry);
        }
    }

    public Object checkFor(String identifier) {
        for (int i = 0; i < this.IdentifierList.size(); i++) {
            if (Objects.equals(this.IdentifierList.get(i), identifier)) {
                return this.OutputList.get(i);
            }
        }
        return null;
    }
}
