package mce.lu.common.event.trigger;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

public class CondenserTrigger implements ICriterionTrigger<CondenserTrigger.Instance> {
	private final ResourceLocation RL;
	public final Map<PlayerAdvancements, CondenserTrigger.Listeners> listeners = Maps.<PlayerAdvancements, CondenserTrigger.Listeners>newHashMap();

	public CondenserTrigger(String parString) {
		super();
		RL = new ResourceLocation(parString);
	}

	public CondenserTrigger(ResourceLocation parRL) {
		super();
		RL = parRL;
	}

	@Override
	public ResourceLocation getId() {
		return RL;
	}

	@Override
	public void addListener(PlayerAdvancements playerAdvancementsIn,
			ICriterionTrigger.Listener<CondenserTrigger.Instance> listener) {
		CondenserTrigger.Listeners myListener = this.listeners.get(playerAdvancementsIn);

		if (myListener == null) {
			myListener = new CondenserTrigger.Listeners(playerAdvancementsIn);
			listeners.put(playerAdvancementsIn, myListener);
		}

		myListener.add(listener);
	}

	@Override
	public void removeListener(PlayerAdvancements playerAdvancementsIn,
			ICriterionTrigger.Listener<CondenserTrigger.Instance> listener) {
		CondenserTrigger.Listeners myListener = this.listeners.get(playerAdvancementsIn);

		if (myListener != null) {
			myListener.remove(listener);

			if (myListener.isEmpty()) {
				listeners.remove(playerAdvancementsIn);
			}
		}
	}

	@Override
	public void removeAllListeners(PlayerAdvancements playerAdvancementsIn) {
		listeners.remove(playerAdvancementsIn);
	}

	/**
	 * Deserialize a ICriterionInstance of this trigger from the data in the
	 * JSON.
	 *
	 * @param json
	 *            the json
	 * @param context
	 *            the context
	 * @return the tame bird trigger. instance
	 */
	@Override
	public CondenserTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
		return new CondenserTrigger.Instance(getId());
	}

	public void trigger(EntityPlayerMP parPlayer) {
		CondenserTrigger.Listeners myListener = this.listeners.get(parPlayer.getAdvancements());

		if (myListener != null) {
			myListener.trigger(parPlayer);
		}
	}

	public static class Instance extends AbstractCriterionInstance {

		/**
		 * Instantiates a new instance.
		 */
		public Instance(ResourceLocation parRL) {
			super(parRL);
		}

		/**
		 * Test.
		 *
		 * @return true, if successful
		 */
		public boolean test() {
			return true;
		}
	}

	static class Listeners {
		private final PlayerAdvancements playerAdvancements;
		private final Set<ICriterionTrigger.Listener<CondenserTrigger.Instance>> listeners = Sets.<ICriterionTrigger.Listener<CondenserTrigger.Instance>>newHashSet();

		public Listeners(PlayerAdvancements playerAdvancementsIn) {
			playerAdvancements = playerAdvancementsIn;
		}

		public boolean isEmpty() {
			return listeners.isEmpty();
		}

		public void add(ICriterionTrigger.Listener<CondenserTrigger.Instance> listener) {
			listeners.add(listener);
		}

		public void remove(ICriterionTrigger.Listener<CondenserTrigger.Instance> listener) {
			listeners.remove(listener);
		}

		public void trigger(EntityPlayerMP player) {
			List<ICriterionTrigger.Listener<CondenserTrigger.Instance>> list = null;

			for (ICriterionTrigger.Listener<CondenserTrigger.Instance> listener : this.listeners) {
				if (((CondenserTrigger.Instance) listener.getCriterionInstance()).test()) {
					if (list == null) {
						list = Lists.<ICriterionTrigger.Listener<CondenserTrigger.Instance>>newArrayList();
					}

					list.add(listener);
				}
			}

			if (list != null) {
				for (ICriterionTrigger.Listener<CondenserTrigger.Instance> listener1 : list) {
					listener1.grantCriterion(playerAdvancements);
				}
			}
		}
	}
}
