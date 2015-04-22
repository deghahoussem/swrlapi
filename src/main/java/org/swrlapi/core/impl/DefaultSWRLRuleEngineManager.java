package org.swrlapi.core.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.swrlapi.core.SWRLRuleEngineManager;

public class DefaultSWRLRuleEngineManager implements SWRLRuleEngineManager
{
	private final Map<String, TargetSWRLRuleEngineCreator> registeredSWRLRuleEngines;

	public DefaultSWRLRuleEngineManager()
	{
		this.registeredSWRLRuleEngines = new HashMap<>();
	}

	@Override
	public void registerRuleEngine(String ruleEngineName, TargetSWRLRuleEngineCreator ruleEngineCreator)
	{
		if (this.registeredSWRLRuleEngines.containsKey(ruleEngineName)) {
			this.registeredSWRLRuleEngines.remove(ruleEngineName);
			this.registeredSWRLRuleEngines.put(ruleEngineName, ruleEngineCreator);
		} else
			this.registeredSWRLRuleEngines.put(ruleEngineName, ruleEngineCreator);
	}

	@Override
	public boolean isRuleEngineRegistered(String ruleEngineName)
	{
		return this.registeredSWRLRuleEngines.containsKey(ruleEngineName);
	}

	@Override
	public boolean hasRegisteredRuleEngines()
	{
		return !this.registeredSWRLRuleEngines.isEmpty();
	}

	@Override
	public String getAnyRegisteredRuleEngineName()
	{
		if (hasRegisteredRuleEngines())
			return this.registeredSWRLRuleEngines.keySet().iterator().next();
		else
			return null;
	}

	@Override
	public SWRLRuleEngineManager.TargetSWRLRuleEngineCreator getRegisteredRuleEngineCreator(String ruleEngineName)
	{
		return this.registeredSWRLRuleEngines.get(ruleEngineName);
	}

	@Override
	public Set<String> getRegisteredRuleEngineNames()
	{
		return this.registeredSWRLRuleEngines.keySet();
	}

	@Override
	public void unregisterSWRLRuleEngine(String ruleEngineName)
	{
		if (this.registeredSWRLRuleEngines.containsKey(ruleEngineName))
			this.registeredSWRLRuleEngines.remove(ruleEngineName);
	}
}
