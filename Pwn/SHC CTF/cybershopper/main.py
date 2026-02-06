from rich import print, rule, table
import os

BALANCE = 10
STORE = {
        "breadboard": 1,
        "esp8266": 2,
        "raspberry pi pico": 5,
        "arduino uno r4": 10,
        "raspberry pi 4": 40,
        "flag": 1337
}

def show_options():
    print(rule.Rule("Products"))
    print("You can buy the following products:")
    tbl = table.Table(show_header=True, header_style="bold magenta", title_style="bold green", width=60)
    tbl.add_column("ID", style="dim", width=12)
    tbl.add_column("Product", style="green", width=12)
    tbl.add_column("Price", justify="right", style="blue")
    for i, (product, price) in enumerate(STORE.items()):
        tbl.add_row(str(i), product, f"{price}$")
    print(tbl)

def buy_product():
    global BALANCE
    show_options()
    print(rule.Rule("Buy product"))
    print("[blue]Enter the ID of the product you want to buy:[/blue]")
    print("[green]> [/green]", end="")
    try:
        product_id = int(input())
    except ValueError:
        print("[red]Invalid product ID[/red]")
        return
    if product_id < 0 or product_id >= len(STORE):
        print("[red]Invalid product ID[/red]")
        return
    product = list(STORE.keys())[product_id]
    print(f"Product: [green]{product}[/green]")
    print(f"Price: [blue]{STORE[product]}$[/blue]")
    # amount
    print(f"Enter the amount of [green]{product}[/green] you want to buy")
    print("[green]> [/green]", end="")
    try:
        amount = int(input())
    except ValueError:
        print("Invalid amount")
        return
    total_price = STORE[product] * amount
    if total_price > BALANCE:
        print("[red]Not enough balance[/red]")
        return
    if product == "flag":
        if not BALANCE >= 31337:
            print("[yellow]You're not worthy of the flag[/yellow]")
            print("[red]Reset your balance to zero. Lol.")
            BALANCE = 0
        else:
            print(os.getenv("FLAG"))
        return
    print(f"Total price: [blue]{total_price}$[/blue]")
    BALANCE -= total_price
    print(f"[green]{amount} {product}[/green] bought successfully")

def main():
    while True:
        print(rule.Rule("Welcome to the store"))
        print(f"Your balance: [blue]{BALANCE}$[/blue]")
        print("1. Buy product")
        print("2. Exit")
        print("Enter your choice:")
        print("[green]> [/green]", end="")
        choice = input()
        if choice == "1":
            buy_product()
        elif choice == "2":
            break
        else:
            print("Invalid choice")

if __name__ == "__main__":
    main()
