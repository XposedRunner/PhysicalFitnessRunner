package android.support.v4.app;

import java.util.List;

public class FragmentManagerNonConfig {
    private final List<FragmentManagerNonConfig> mChildNonConfigs;
    private final List<Fragment> mFragments;

    FragmentManagerNonConfig(List<Fragment> list, List<FragmentManagerNonConfig> list2) {
        this.mFragments = list;
        this.mChildNonConfigs = list2;
    }

    /* Access modifiers changed, original: 0000 */
    public List<FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    /* Access modifiers changed, original: 0000 */
    public List<Fragment> getFragments() {
        return this.mFragments;
    }
}
