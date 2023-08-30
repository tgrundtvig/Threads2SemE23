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

	public synchronized ProductType getProduct()
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
}
