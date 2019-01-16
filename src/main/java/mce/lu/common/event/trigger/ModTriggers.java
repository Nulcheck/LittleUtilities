package mce.lu.common.event.trigger;

public class ModTriggers {
	public static final CondenserTrigger CONDENSE_BLAZE_ROD = new CondenserTrigger("condense_blaze_rod");
	public static final CondenserTrigger CONDENSE_ENDER_EYE = new CondenserTrigger("condense_ender_eye");
	public static final CondenserTrigger CONDENSE_GHAST_TEAR = new CondenserTrigger("condense_ghast_tear");
	public static final CondenserTrigger CONDENSE_NETHER_STAR = new CondenserTrigger("condense_nether_star");

	public static final CondenserTrigger[] TRIGGER_ARRAY = new CondenserTrigger[] { CONDENSE_BLAZE_ROD,
			CONDENSE_ENDER_EYE, CONDENSE_GHAST_TEAR, CONDENSE_NETHER_STAR };
}
