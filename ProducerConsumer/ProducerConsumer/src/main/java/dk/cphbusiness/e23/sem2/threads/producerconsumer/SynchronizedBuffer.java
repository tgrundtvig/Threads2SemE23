package dk.cphbusiness.e23.sem2.threads.producerconsumer;

import dk.cphbusiness.e23.sem2.datastructures.circulararray.CircularArray2;

public class SynchronizedBuffer<ProductType> implements ISyncBuffer<ProductType>
{
	private CircularArray2<ProductType> products;

	public SynchronizedBuffer(int capacity)
	{
		products = new CircularArray2<>(capacity);
	}

	public synchronized void addProduct(ProductType product)
	{
		while (this.products.availableSpace() < 1)
		{
			try
			{
				this.wait(); //This releases the lock on teddyBear
			} catch (InterruptedException e)
			{
			}
		}
		this.products.addLast(product);
		this.notifyAll();
	}

	public synchronized ProductType getProductBlocking()
	{
		while (this.products.size() < 1)
		{
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
			}
		}
		ProductType res = products.removeFirst();
		this.notifyAll();
		return res;
	}

	@Override
	public synchronized ProductType getProductUnblocking()
	{
		if (this.products.size() < 1)
		{
			return null;
		}
		ProductType res = products.removeFirst();
		this.notifyAll();
		return res;
	}

	@Override
	public synchronized int getSize()
	{
		return products.size();
	}

	@Override
	public synchronized int getCapacity()
	{
		return products.capacity();
	}
}
