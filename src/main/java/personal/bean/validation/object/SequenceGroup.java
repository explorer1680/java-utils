package personal.bean.validation.object;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({BasicInfo.class, AdvanceInfo.class, Default.class})
public interface SequenceGroup {

}
