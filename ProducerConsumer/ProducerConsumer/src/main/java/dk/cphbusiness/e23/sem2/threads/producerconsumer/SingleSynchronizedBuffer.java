package dk.cphbusiness.e23.sem2.threads.producerconsumer;

public class SingleSynchronizedBuffer<ProductType> implements ISyncBuffer<ProductType>
{
	private ProductType product;

	public SingleSynchronizedBuffer()
	{
		product = null;
	}

	public void addProduct(ProductType product)
	{
		synchronized (this)
		{
			while (this.product != null)
			{
				try
				{
					this.wait(); //This releases the lock on teddyBear
				} catch (InterruptedException e)
				{
				}
			}
			this.product = product;
			this.notifyAll();
		} //This releases the lock on teddyBear
	}

	public synchronized ProductType getProductBlocking()
	{
		while (product == null)
		{
			try
			{
				this.wait(); //This releases the lock on teddyBear
			} catch (InterruptedException e)
			{
			}
		}
		ProductType temp = product;
		product = null;
		this.notifyAll();
		return temp;
	}

	@Override
	public ProductType getProductUnblocking()
	{
		while (product == null)
		{
			return null;
		}
		ProductType temp = product;
		product = null;
		this.notifyAll();
		return temp;
	}

	@Override
	public synchronized int getSize()
	{
		return (product == null ? 0 : 1);
	}

	@Override
	public int getCapacity()
	{
		return 1;
	}
}
