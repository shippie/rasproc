package de.railroad.rasproc.tools;

import java.util.concurrent.atomic.AtomicLong;

public class UniqId
{

	private volatile static UniqId _instance;
	private AtomicLong id = new AtomicLong(0);

	public static UniqId getInstanceDC()
	{
		if (_instance == null)
		{
			synchronized (UniqId.class)
			{
				if (_instance == null)
				{
					_instance = new UniqId();
				}
			}
		}
		return _instance;
	}

	public long getId()
	{
		return id.incrementAndGet();
	}

}
