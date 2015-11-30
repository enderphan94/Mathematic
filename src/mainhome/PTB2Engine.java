package mainhome;

public class PTB2Engine {
	private double a;
	private double b;
	private double c;

	public PTB2Engine(double a, double b, double c)

	{

		this.a = a;

		this.b = b;

		this.c = c;

	}

	public String compute()

	{

		String kq = "";

		if (this.a == 0)

		{

			if (this.b == 0)

			{

				if (this.c == 0)

				{

					kq = "Many roots";

				}

				else

				{

					kq = "Vacant roots";

				}

			}

			else

			{

				kq = "Only one root x1=" + (-this.c / this.b);

			}

		}

		else

		{

			double delta = this.b * this.b - 4 * this.a * this.c;

			if (delta < 0)

				kq = "Vacant";

			else if (delta == 0)

				kq = "No pair x1=x2=" + (-this.b / (2 * this.a));

			else

			{

				kq = "X1 = " + ((-this.b - Math.sqrt(delta)) / (2 * this.a));

				kq += "  ||   X2 = " + ((-this.b + Math.sqrt(delta)) / (2 * this.a));

			}

		}

		return kq;

	}

}
