package dataStructures;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pair<F, S> {

    public F first;

    public S second;
}
